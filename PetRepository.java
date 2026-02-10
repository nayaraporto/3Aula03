package com.pet_shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pet_shop.Entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
