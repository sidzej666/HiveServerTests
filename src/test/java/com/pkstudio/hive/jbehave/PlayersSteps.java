package com.pkstudio.hive.jbehave;

import javax.inject.Inject;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.web.client.RestTemplate;

import com.pkstudio.hive.players.PlayerDto;

@Steps
public class PlayersSteps {

	private RestTemplate restTemplate;
	private PlayerDto playerDto;
	
	@Inject
	public PlayersSteps(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Given("a playerDto")
	public void givenAPlayerDto() {
		playerDto = new PlayerDto();
	}

	@Given("name set to $name")
	public void givenNameSetToname(@Named("name") String name) {
		playerDto.setName(name);
	}

	@Given("email set to $email")
	public void givenEmailSetToemail(@Named("email") String email) {
		playerDto.setEmail(email);
	}

	@When("I create a player")
	public void whenICreateAPlayer() {
		playerDto = restTemplate.postForObject("http://localhost:8080/HiveServer/players", playerDto, PlayerDto.class);
	}

	@Then("a player should be created")
	public void thenAPlayerShouldBeCreated() {
		//TODO: check if player exists after creation
	}

}
