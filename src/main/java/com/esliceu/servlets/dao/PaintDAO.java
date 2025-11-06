package com.esliceu.servlets.dao;

import com.esliceu.servlets.models.Paint;
import java.util.List;


public interface PaintDAO {

    void save(Paint paint);
    void delete(String name);
    List<Paint> getAllPaints();
    List<Paint> getPaintsByOwner(String owner);
    boolean namePaintExists(String name);
    boolean deletePaintByNameAndOwner(String name, String owner);
    boolean savePaint(Paint paint);
    boolean selectPaintByNameAndOwner(String name, String owner);


}
