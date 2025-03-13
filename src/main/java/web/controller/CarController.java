package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars/")
    public String printCars(ModelMap model) {
        List<String> cars = new ArrayList<>();
        cars.add("Car1");
        cars.add("Car2");
        cars.add("Car3");
        model.addAttribute("cars", cars);
        return "cars";
    }
}
