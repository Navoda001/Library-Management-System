package com.library.LibMgmt2025.dao;

import com.library.LibMgmt2025.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity,String> {
    // JPQL query to get available quantity
    @Query("SELECT SUM(b.availableQty) FROM BookEntity b WHERE b.bookId = :bookId")
    int avlilQty(@Param("bookId") String bookId);  // Change return type to Long

    // Deduct book count based on lending
    @Modifying
    @Query("UPDATE BookEntity b SET b.availableQty = b.availableQty - 1 WHERE b.bookId = :bookId AND b.availableQty > 0")  // Fixed typo in 'availableQty'
    int deductBasedOnLending(@Param("bookId") String bookId);
}
