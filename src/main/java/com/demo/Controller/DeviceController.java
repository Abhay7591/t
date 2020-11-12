package com.demo.Controller;

import com.demo.Model.Device;
import com.demo.Repository.DeviceRepository;
import com.demo.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DeviceController {


        @Autowired
        private DeviceService deviceService;

        @Autowired
        private DeviceRepository deviceRepository;


        @GetMapping("/devices")
        public ResponseEntity<List<Device>>getAllProduct(){
           System.out.println("Working fine");
           // return deviceRepository.findAll();
            return ResponseEntity.ok().body(deviceService.getAllDevices());
        }

        @GetMapping("/device/{id}")
        public ResponseEntity<Device> getProductById(@PathVariable String id){
            return ResponseEntity.ok().body(deviceService.getDeviceById(id));
        }

        @PostMapping("/device")
        public ResponseEntity<Device> createDevice(@RequestBody Device device){
           // return ResponseEntity.ok().body(this.deviceService.createDevice(device));
            return ResponseEntity.ok().body(deviceRepository.save(device));
        }

        @PutMapping("/device/{id}")
        public ResponseEntity<Device> updateDevice(@PathVariable String id, @RequestBody Device device){
            device.setDeviceId(id);
            return ResponseEntity.ok().body(this.deviceService.updateDevice(device));
        }

        @DeleteMapping("/device/{id}")
        public HttpStatus deleteDevice(@PathVariable String id){
            this.deviceService.deleteDevice(id);
            return HttpStatus.OK;
        }
    }

