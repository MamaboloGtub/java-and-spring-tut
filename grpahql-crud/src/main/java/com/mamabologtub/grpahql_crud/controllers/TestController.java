//package com.mamabologtub.grpahql_crud.controllers;
//
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import graphql.com.google.common.collect.ImmutableMap;
//import io.swagger.v3.oas.annotations.Operation;
//
///**
// * @Author Tshepo M Mahudu on Jul 2, 2025.
// */
//@Controller
//public class TestController {
//
//    @RequestMapping(
//            method = RequestMethod.GET,
//            path = "/hello",
//            produces = "application/json")
//    // https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#api
//    @Operation(
//            tags = "index", // To avoid indexUsingGET in ApiClient
//            description = "Says hello to you",
//            summary = "This endpoint just tells you a greeting message.<br/>" +
//            "See also: https://en.wikipedia.org/wiki/%22Hello,_World!%22_program")
//    public Map<String, String> index() {
//        return ImmutableMap.<String, String>builder().put("message", "Hello, World!").build();
//    }
//
//    @RequestMapping(
//            method = RequestMethod.POST,
//            path = "/hello",
//            consumes = "application/x-www-form-urlencoded",
//            produces = "application/json")
//    @Operation(
//            tags = "replyTo", // To avoid replyToUsingGET in ApiClient
//            description = "Replies to your message",
//            summary = "This endpoint just replies to your message.")
//    public Map<String, String> replyTo(@RequestParam(required = true) String message) {
//        return ImmutableMap.<String, String>builder().put("message", "Wow, you said '" + message + "'. Thanks!").build();
//    }
//}
