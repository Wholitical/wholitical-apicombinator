package org.wholitical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.wholitical.service.OpenFECService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@SpringBootApplication
public class ApicombinatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicombinatorApplication.class, args);
	}

	@Bean
	public OpenFECService openFECService() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.open.fec.gov/")
				.addConverterFactory(JacksonConverterFactory.create())
				.build();

		return retrofit.create(OpenFECService.class);
	}

}
