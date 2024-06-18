package hu.temetkezes.demo.controllers;

import hu.temetkezes.demo.models.FuneralService;
import hu.temetkezes.demo.services.FuneralServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/funeralServices")
public class FuneralServiceController {

    @Autowired
    private final FuneralServiceService funeralServiceService;

    public FuneralServiceController(FuneralServiceService funeralServiceService) {
        this.funeralServiceService = funeralServiceService;
    }

    @GetMapping
    public List<FuneralService> getAll(){
        return funeralServiceService.getAll();
    }
}
