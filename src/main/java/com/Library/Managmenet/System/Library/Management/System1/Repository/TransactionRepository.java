package com.Library.Managmenet.System.Library.Management.System1.Repository;

import com.Library.Managmenet.System.Library.Management.System1.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
