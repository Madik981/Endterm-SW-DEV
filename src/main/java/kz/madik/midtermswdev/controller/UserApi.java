package kz.madik.midtermswdev.controller;

import kz.madik.midtermswdev.entity.UserModel;
import kz.madik.midtermswdev.service.ItemService;
import kz.madik.midtermswdev.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final MyUserService myUserService;
    private final ItemService itemService;

    @GetMapping
    public String getUser() {
        return "Authorized";
    }

    @PostMapping("/registr")
    public void register(@RequestBody UserModel model) {
        myUserService.registr(model);
    }

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getItems() {
        return ResponseEntity.ok(itemService.getAll());
    }
}
