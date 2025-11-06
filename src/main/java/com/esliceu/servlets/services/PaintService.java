package com.esliceu.servlets.services;

import com.esliceu.servlets.dao.PaintDAO;
import com.esliceu.servlets.dao.PaintDAOInMemory;
import com.esliceu.servlets.models.Paint;

import java.util.List;

public class PaintService {
    private static PaintService instance;
    private PaintDAO paintDAO = new PaintDAOInMemory();

    public PaintService() {

    }

    public static PaintService getInstance() {
        if (instance == null) {
            instance = new PaintService();
        }
        return instance;
    }

    public boolean savePaint(Paint paint) {
        return paintDAO.savePaint(paint);
    }

    public boolean deletePaintByNameAndOwner(String name, String owner) {
        return paintDAO.deletePaintByNameAndOwner(name, owner);
    }

    public boolean namePaintExists(String name) {
        return paintDAO.namePaintExists(name);
    }

    public boolean selectPaintByNameAndOwner(String name, String owner){
        return paintDAO.selectPaintByNameAndOwner(name, owner);
    }


    public List<Paint> getAllPaints() {
        return paintDAO.getAllPaints();
    }

    public List<Paint> getPaintsByOwner(String owner) {
        return paintDAO.getPaintsByOwner(owner);
    }

}
