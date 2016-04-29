package org.wholitical.service;

import org.wholitical.domain.Candidate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by Lee on 4/28/16.
 */
public interface OpenFECService {

    /**
     * @param state two letter state code
     * @param district
     * @param electionYear
     * @return
     */
    @GET("/v1/candidates")
    Call<List<Candidate>> getCandidatesByStateAndDistrict(@Query("state") String state, @Query("district") int district, @Query("election_year") int electionYear);
}
