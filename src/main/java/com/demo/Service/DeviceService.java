package com.demo.Service;

import com.demo.Model.Device;

import java.util.List;

public interface DeviceService {

    Device createDevice(Device device);

    Device updateDevice(Device device);

    List<Device> getAllDevices();

    Device getDeviceById(String DeviceId);

    void deleteDevice(String id);
}
