package org.wholitical.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wholitical.domain.Candidate;
import org.wholitical.domain.States;
import org.wholitical.service.OpenFECService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 *
 */
@Slf4j
@RestController
public class CandidatesController {

    @Autowired
    private OpenFECService openFECService;

    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public List<Candidate> defaultThing() throws IOException {
        Call<List<Candidate>> toReturn = openFECService.getCandidatesByStateAndDistrict(States.MICHIGAN.getANSIabbreviation(), 1, 2016);
        System.out.println(toReturn.request());
        Response<List<Candidate>> candidatesResponse = toReturn.execute();
        System.out.println(candidatesResponse.message());
        return candidatesResponse.body();
    }


}
