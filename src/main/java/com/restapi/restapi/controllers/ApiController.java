package com.restapi.restapi.controllers;


import com.restapi.restapi.entities.CarEntity;
import com.restapi.restapi.repositories.CarRepository;
import com.restapi.restapi.response.CommonResponse;
import com.restapi.restapi.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class ApiController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;


    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi(){
        return commonResponseGenerator.successResponse("haloo kaka", "Succes check api");
    }

    // controller membuat data baru mobil
    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param){
        carRepository.save(param);
        return param;
    }

    // controller mencari semua data
    // localhost:8080/car/getAllCar
    @GetMapping(value = "getAllCar")
    public List<CarEntity> getAllCar(){
        return carRepository.findAll();
    }

    // controller mencari sesuai id
    // localhost:8080/car/getById?id=1
    @GetMapping(value = "getById")
    public CarEntity getById(@RequestParam int id){
        return carRepository.findById(id).get();
    }

    // contorller update
    // bisa menggunakan to.string pada akhir retunr
    // bisa juga di ganti dengan CarEntity String nya
    @PostMapping(value = "updateCar")
    public CarEntity updateCar(@RequestBody CarEntity param){
        // jika menggunakan public String maka tulish retunr di bawah ini terlihat FORMAT STIRNG
        // return carRepository.save(param).toString();
        // jika menggunakan public CarEntity seperti di bawah ini akan terlihat  FORMAT JSON
        return carRepository.save(param);
    }

    // controller delete menampilkan Stirng pada console
    // jika ingin menampilkan json yang terdelete
    // CarEntity car = carRepository.findById(id).get();
    // return nya "car" aja
    @GetMapping(value = "deleteCar")
    public List<CarEntity> deleteCar(@RequestParam int id){

        carRepository.deleteById(id);
        List<CarEntity> carList = carRepository.findAll();
        //return "Success delete Car id " + id;
        return carList;
    }






}
