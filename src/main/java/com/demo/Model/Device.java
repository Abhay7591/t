package com.demo.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.Getter;
//import lombok.Setter;*/


@Document(collection = "DeviceDetails")
public class Device {

    @Id
    private String deviceId;
    @JsonProperty("OS")
    private String OS;
    @JsonProperty("OS")
    private String OS_Version;
    @JsonProperty("OS")
    private String deviceType;

    public Device(String deviceId, String OS, String OS_Version, String deviceType) {
        this.deviceId = deviceId;
        this.OS = OS;
        this.OS_Version = OS_Version;
        this.deviceType = deviceType;
    }
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getOS_Version() {
        return OS_Version;
    }

    public void setOS_Version(String OS_Version) {
        this.OS_Version = OS_Version;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", OS='" + OS + '\'' +
                ", OS_Version='" + OS_Version + '\'' +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}