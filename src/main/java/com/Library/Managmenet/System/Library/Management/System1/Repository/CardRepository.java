package com.Library.Managmenet.System.Library.Management.System1.Repository;

import com.Library.Managmenet.System.Library.Management.System1.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
