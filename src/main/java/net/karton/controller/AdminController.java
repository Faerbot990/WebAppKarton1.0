package net.karton.controller;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import net.karton.model.Good;
import net.karton.service.GoodService;
import org.glassfish.jersey.internal.util.collection.Views;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
@Secured("ROLE_ADMIN")
public class AdminController {

    private final GoodService goodService;

    @PostMapping("good")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @JsonView(Views.ShortGood.class)
    public Good create(@RequestBody Good good) {
        return goodService.save(good);
    }

    @DeleteMapping("good/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public void delete(@PathVariable("id") Good good) {
        goodService.delete(good);
    }

    @PostMapping("good/{id}")
    @JsonView(Views.ShortGood.class)
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public Good update(@PathVariable("id") Good goodFromDb, @RequestBody Good good) {
        return goodService.update(goodFromDb, good);
    }
}
