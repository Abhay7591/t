package com.demo.Service;

import com.demo.Exception.DeviceNotFoundException;
import com.demo.Model.Device;
import com.demo.Repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

@Service
public class DeviceServiceImpl implements DeviceService {


        @Autowired
        private DeviceRepository deviceRepository;


        @Override
        public Device createDevice(Device device) {
            return deviceRepository.save(device);
        }

        @Override
        public Device updateDevice(Device device) {
            Optional<Device> deviceDb = this.deviceRepository.findById(device.getDeviceId());

            if(deviceDb.isPresent()) {
                Device UpdatedDevice = deviceDb.get();
                UpdatedDevice.setDeviceId(device.getDeviceId());
                UpdatedDevice.setOS(device.getOS());
                UpdatedDevice.setOS_Version(device.getOS_Version());
                UpdatedDevice.setDeviceType(device.getDeviceType());

                deviceRepository.save(UpdatedDevice);
                return UpdatedDevice;
            }else {
                throw new DeviceNotFoundException("Record not found with id : " + device.getDeviceId());
            }
        }

        @Override
        public List<Device> getAllDevices() {
            return this.deviceRepository.findAll();
        }

        @Override
        public Device getDeviceById(String deviceId) {

            Optional<Device> productDb = this.deviceRepository.findById(deviceId);

            if(productDb.isPresent()) {
                return productDb.get();
            }else {
                throw new DeviceNotFoundException("Record not found with id : " + deviceId);
            }
        }

        @Override
        public void deleteDevice(String deviceId) {
            Optional<Device> productDb = this.deviceRepository.findById(deviceId);

            if(productDb.isPresent()) {
                this.deviceRepository.deleteById(deviceId);
            }else {
                throw new DeviceNotFoundException("Record not found with id : " + deviceId);
            }

        }

    }
