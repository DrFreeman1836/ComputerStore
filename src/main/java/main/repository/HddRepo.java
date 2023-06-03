package main.repository;

import main.model.Hdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HddRepo extends JpaRepository<Hdd, Long> {

}
