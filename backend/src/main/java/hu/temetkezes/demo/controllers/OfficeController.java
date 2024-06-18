package hu.temetkezes.demo.controllers;

import hu.temetkezes.demo.models.Office;
import hu.temetkezes.demo.services.OfficeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
class RegionCode{

    private String region;
    private String code;

    public RegionCode(String region, String code){
        this.region=region;
        this.code=code;
    }

}

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    private final OfficeService officeService;


    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }
    @GetMapping("/{id}")
    public Office getOfficeById(@PathVariable Long id) {
        return officeService.getOfficeById(id);
    }

    @GetMapping
    public List<Office> getAllOffice() {
        return officeService.getOffices();
    }

    @GetMapping("/getbycode/{code}")
    public List<Office> getAllOfficeByCode(@PathVariable String code) {
        return officeService.getOffices().stream().filter(office -> Objects.equals(office.getCode(), code)).toList();
    }

    @GetMapping("/codes")
    public List<String> getAllCode() {
        List<String> codes = new ArrayList<>();
        for (Office office : officeService.getOffices()){
            if (!codes.contains(office.getCode()))
                codes.add(office.getCode());
        }
        return codes;
    }



    @GetMapping("/regions")
    public List<String> getAllRegion() {
        List<String> regions = new ArrayList<>();
        for (Office office : officeService.getOffices()){
            if (!regions.contains(office.getRegion()))
                regions.add(office.getRegion());
        }
        return regions;
    }


    @GetMapping("/regionsAndCodes")
    public List<RegionCode> getAllRegionAndCode() {
        List<RegionCode> regions = new ArrayList<>();
        for (Office office : officeService.getOffices()){
            if (regions.stream().noneMatch(r -> Objects.equals(r.getCode(), office.getCode())))
                regions.add(new RegionCode(office.getRegion(),office.getCode()));
        }
        return regions;
    }
    public void addOffice(@RequestBody Office office) {
        officeService.saveOffice(office);
    }
    public void updateOffice(@PathVariable Long id, @RequestBody Office office) {
        Office existingOffice = officeService.getOfficeById(id);
        if (existingOffice != null) {
            office.setId(id); // Ensure the correct ID is set
            officeService.updateOffice(office);
        }
    }
    public void deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);
    }
}
