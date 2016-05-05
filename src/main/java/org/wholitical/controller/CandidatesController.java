package org.wholitical.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.wholitical.domain.Candidates;
import org.wholitical.domain.District;
import org.wholitical.domain.States;
import org.wholitical.repository.DistrictRepository;
import org.wholitical.service.OpenFECService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;

/**
 *
 */
@Slf4j
@RestController
public class CandidatesController {

    @Autowired
    private OpenFECService openFECService;

    @Autowired
    private DistrictRepository districtRepository;

    @Value("${openfec.apiKey}")
    private String fecApiKey;

    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public Candidates defaultThing(@RequestParam String state, @RequestParam int district, @RequestParam int year) throws IOException {
        Call<Candidates> toReturn = openFECService.getCandidatesByStateAndDistrict(States.parse(state).getANSIabbreviation(), district, year, fecApiKey);
        Response<Candidates> candidatesResponse = toReturn.execute();
        return candidatesResponse.body();
    }

    @RequestMapping(value= "/candidates/{zipcode}", method = RequestMethod.GET)
    public Candidates byZipcode(@PathVariable int zipcode) throws IOException {
        District district = districtRepository.findOne(zipcode);

        Call<Candidates> toReturn = openFECService.getCandidatesByStateAndDistrict(States.parse(district.getState()).getANSIabbreviation(), district.getDistrict(), LocalDate.now().getYear(), fecApiKey);
        Response<Candidates> candidatesResponse = toReturn.execute();
        return candidatesResponse.body();
    }

}
