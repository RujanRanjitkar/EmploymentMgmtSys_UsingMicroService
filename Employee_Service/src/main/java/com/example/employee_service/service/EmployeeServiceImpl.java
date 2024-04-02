package com.example.employee_service.service;

import com.example.employee_service.dto.AddressResponseDto;
import com.example.employee_service.dto.EmployeeRequestDto;
import com.example.employee_service.dto.EmployeeResponseDto;
import com.example.employee_service.model.Employee;
import com.example.employee_service.openFeignClient.AddressClient;
import com.example.employee_service.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

//    @Value("${addressservice.base.url}")
//    private String addressBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressClient addressClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    // use this constructor if you dont want to make configuration bean for rest template and autowire it
//    public EmployeeServiceImpl(@Value("${addressservice.base.url}") String addressBaseUrl, RestTemplateBuilder builder) {
//        this.restTemplate=builder
//                .rootUri(addressBaseUrl)
//                .build();
//    }

    @Override
    public EmployeeResponseDto getEmployeeById(int employeeId) {

        Employee employee = employeeRepo.findById(employeeId).get(); //db call

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setEmployeeName(employee.getEmployeeName());
        employeeResponseDto.setEmail(employee.getEmail());
        employeeResponseDto.setBloodGroup(employee.getBloodGroup());

        //addressResponseDto -> set data by making a rest api call
//        AddressResponseDto addressResponseDto=callingAddressServiceUsingRestTemplate(employeeId); //external rest api used this line to call rest template method

        AddressResponseDto addressResponseDto = addressClient.getAddressByEmployeeId(employeeId).getBody() ;

        employeeResponseDto.setAddressResponseDto(addressResponseDto);

        return employeeResponseDto;
    }

    private AddressResponseDto callingAddressServiceUsingRestTemplate(int employeeId) {

        //get the details for the ip and a port number for address service

//        List<ServiceInstance> instances=discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance=instances.get(0);
//        String uri=serviceInstance.getUri().toString();

//        ServiceInstance serviceInstance=loadBalancerClient.choose("address-service");
//        String uri=serviceInstance.getUri().toString();
//        String contextRoot=serviceInstance.getMetadata().get("configPath");
//
//        System.out.println("uri>>>>>>>>>>>>" + uri + contextRoot);
//        return restTemplate.getForObject(uri + contextRoot + "/get_address_by_employee_id/{employeeId}", AddressResponseDto.class, employeeId);

        return restTemplate.getForObject("http://address-service/address-app/api/get_address_by_employee_id/{employeeId}", AddressResponseDto.class, employeeId);

    }

    @Override
    public void addNewEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();

        employee.setEmployeeName(employeeRequestDto.getEmployeeName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setBloodGroup(employeeRequestDto.getBloodGroup());

        employeeRepo.save(employee);
    }
}
