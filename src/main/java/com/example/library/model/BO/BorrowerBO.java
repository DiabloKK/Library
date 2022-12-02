package com.example.library.model.BO;


import com.example.library.model.DAO.BorrowerDAO;
import com.example.library.model.entity.Borrower;

import java.sql.SQLException;
import java.util.List;

public class BorrowerBO {
    private BorrowerDAO borrowerDAO;

    public BorrowerBO() {
        borrowerDAO = new BorrowerDAO();
    }

    public List<Borrower> getBorrowers() {
        return borrowerDAO.getBorrowers();
    }

    public void save(Borrower borrower) {
        borrowerDAO.save(borrower);
    }

    public void update(Borrower borrower) {
        borrowerDAO.update(borrower);
    }

    public void delete(Integer id) {
        borrowerDAO.delete(id);
    }

    public void deleteAllReader() throws ClassNotFoundException, SQLException {
        int result =  borrowerDAO.deleteAllReader();
    }
}
