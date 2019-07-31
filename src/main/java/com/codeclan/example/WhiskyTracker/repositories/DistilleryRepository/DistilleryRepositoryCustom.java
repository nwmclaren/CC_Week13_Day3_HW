package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;

import java.util.List;

public interface DistilleryRepositoryCustom {

    List<Distillery> getDistilleryFromRegion(String region);

    List<Distillery> getDistilleryWithWhiskyAge(int age);
}
