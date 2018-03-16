package cn.dawn.day07annotationdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Dawn on 2018/3/5.
 */
@Component("car")
public class Car {
    @Value("红色")
    private String color;
    @Value("奔驰")
    private String type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
