package com.example.library.model.BO;


import com.example.library.model.DAO.BorrowerDAO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Borrower;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class BorrowerBO {
    private BorrowerDAO borrowerDAO;
    private BookBO bookBO;

    public BorrowerBO() {
        borrowerDAO = new BorrowerDAO();
        bookBO = new BookBO();
    }

    public List<Borrower> getBorrowers() {

        List<Borrower> borrowers= new ArrayList<>();
        borrowers = borrowerDAO.getBorrowers();
        for (Borrower borrower : borrowers) {
            borrower.setBook_name(bookBO.getNameById(borrower.getBook_id()));
        }
        return borrowers;
    }
    public List<Borrower> getBorrowersWithCondition(String condition) {
        List<Borrower> borrowers = new ArrayList<>();

        for (Borrower borrower : getBorrowers()) {
            if (condition.equals("returned") ){
                if (borrower.isStatus()) {
                    borrowers.add(borrower);
                }
            }
            else {
                if (condition.equals("over")) {
                    Date date = Date.valueOf(LocalDate.now());
                    if (date.compareTo(borrower.getDeadline_date()) == 1 && borrower.isStatus() == false) {
                        borrowers.add(borrower);
                    }
                }
                if (condition.equals("borrowed")) {
                    Date date = Date.valueOf(LocalDate.now());
                    if (date.compareTo(borrower.getDeadline_date()) != 1 && borrower.isStatus() == false) {
                        borrowers.add(borrower);
                    }
                }
            }

        }
        return borrowers;
    }

    public void save(String nameBorrowed, int idBook, String duration, String MSSV) {
        Borrower borrower = new Borrower();
        borrower.setName(nameBorrowed);
        borrower.setMssv(MSSV);
        borrower.setBook_id(idBook);
        borrower.setBook_name(bookBO.getNameById(borrower.getBook_id()));
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        borrower.setBorrower_date(date);

        if(duration.equals("1 week")){
            localDate = localDate.plusDays(7);
            System.out.println("1 week" );
            System.out.println(localDate);

        }
        if(duration.equals("2 weeks")){
            localDate =localDate.plusDays(14);
            System.out.println("2 week" );
            System.out.println(localDate);


        }
        if(duration.equals("1 month")){
            localDate = localDate.plusMonths(1);
            System.out.println("3 week" );
            System.out.println(localDate);


        }
        if(duration.equals("3 months")){
            localDate =localDate.plusMonths(3);
            System.out.println("4 week" );
            System.out.println(localDate);


        }

        borrower.setDeadline_date(Date.valueOf(localDate));
        borrower.setStatus(false);
        System.out.println(borrower);
        borrowerDAO.save(borrower);
    }

    public void update(Borrower borrower) {
        borrowerDAO.update(borrower);
    }


    public void delete(Integer id) {
        borrowerDAO.delete(id);
    }

    public void updateStatusAndReturnDate(Integer id) {
        Borrower borrower = getById(id);
        System.out.print(borrower);
        borrower.setStatus(true);
        Date date = Date.valueOf(LocalDate.now());
        borrower.setReturn_date(date);
        System.out.print(borrower);
        update(borrower);
    }
    public  Borrower getById(Integer id) {
        for (Borrower borrower : getBorrowers()) {
            if(borrower.getId() == id){
                return  borrower;
            }
        }
        return null;
    }
}
