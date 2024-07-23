package hu.temetkezes.demo.controllers;



public record AuthResponse(Long id, String name, String role,String token) {
}