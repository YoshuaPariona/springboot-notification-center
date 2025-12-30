package com.bot.telegram.restBot;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile("restBot")
@RestController
@RequestMapping("/alert")
public class RestBotController {

    private final RestBotService restBotService;

    public RestBotController(RestBotService restBotService) {
        this.restBotService = restBotService;
    }

    @GetMapping("/{number}")
    public String sendAlert1(@PathVariable Integer number){
        restBotService.sendAlert("Alerta número " + number);
        return "Mensaje enviado correctamente";
    }

}
