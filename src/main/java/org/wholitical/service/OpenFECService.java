package org.wholitical.service;

import org.wholitical.domain.Candidates;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
    Call<Candidates> getCandidatesByStateAndDistrict(@Query("state") String state, @Query("district") int district, @Query("election_year") int electionYear, @Query("api_key") String apiKey);
}
