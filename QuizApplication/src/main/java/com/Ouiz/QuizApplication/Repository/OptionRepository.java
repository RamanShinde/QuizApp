package com.Ouiz.QuizApplication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ouiz.QuizApplication.Entity.OptionTable;

@Repository
public interface OptionRepository extends JpaRepository<OptionTable,Long> {

}
