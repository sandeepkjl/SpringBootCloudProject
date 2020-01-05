package com.example.sandeep.transferservice.service;

import com.example.sandeep.transferservice.model.LimitModel;
import com.example.sandeep.transferservice.model.TransferRequest;
import com.example.sandeep.transferservice.model.TransferResponse;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class TransferService {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @Value("${limit.service.name}")
    String servicename;
    public TransferResponse doTransfer(TransferRequest request){
        System.out.println(servicename);
        ServiceInstance instance=loadBalancerClient.choose(servicename);
        System.out.println(instance);


        URI uri = URI.create(String.format("http://%s:%s",instance.getHost(),instance.getPort()));
        String url= uri.toString()+"/findLimit";
        System.out.println(uri);
        ResponseEntity<LimitModel> serviceResponse= restTemplate.getForEntity(url,LimitModel.class);

        System.out.println(serviceResponse.getBody());
        TransferResponse response=mapResponse(serviceResponse.getBody(),request);
        return  response;


    }

    private TransferResponse mapResponse(LimitModel limitModel,TransferRequest request){
        TransferResponse response=null;
        if(limitModel.getDailyMaxLimit()>=1600 && limitModel.getMaxLimit()>-4000){
            response=new TransferResponse(request.getFromAccountId(),request.getToAccountId(),request.getAmount(),"success");
        }
        else{
            response=new TransferResponse(request.getFromAccountId(),request.getToAccountId(),request.getAmount(),"failed");
        }

        return  response;
    }
}
