package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.ApiResponse;
import cn.edu.bjut.librarymanagementsystem.dto.RegisterRequest;
import cn.edu.bjut.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllUsers(){
        return ResponseEntity.ok(new ApiResponse(true, "GET_ALL_USERS_SUCCESS", userService.getAllUsers()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Integer id, @RequestBody RegisterRequest req) {
        boolean updated = userService.updateUser(id, req);
        return updated ? ResponseEntity.ok(new ApiResponse(true, "USER_UPDATED_SUCCESSFULLY", null)) :
                ResponseEntity.ok(new ApiResponse(false, "USER_UPDATE_FAILED", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse(true, "USER_DELETED_SUCCESSFULLY", null));
    }
}

