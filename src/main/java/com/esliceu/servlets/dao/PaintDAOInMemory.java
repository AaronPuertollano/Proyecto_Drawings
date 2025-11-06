package com.esliceu.servlets.dao;

import com.esliceu.servlets.models.Paint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PaintDAOInMemory implements PaintDAO{

    private Map<Integer, Paint> storage = new HashMap<>();
    private int currentId = 1;

    @Override
    public void save(Paint paint) {
        paint.setId(currentId);  // Asigna el ID dentro del objeto
        storage.put(currentId++, paint);
    }

    @Override
    public void delete(String name) {
        // Buscar la entrada correspondiente al nombre y eliminarla
        storage.entrySet().removeIf(entry -> entry.getValue().getName().equals(name));
    }

    @Override
    public List<Paint> getPaintsByOwner(String owner) {
        return storage.values().stream()
                .filter(paint -> paint.getOwner().equals(owner))
                .collect(Collectors.toList());
    }

    @Override
    public List<Paint> getAllPaints() {
        return new ArrayList<>(storage.values());
    }


    @Override
    public boolean namePaintExists(String name) {
        return storage.values().stream()
                .anyMatch(paint -> paint.getName().equals(name));
    }

    @Override
    public boolean deletePaintByNameAndOwner(String name, String owner) {
        List<Paint> paints = getPaintsByOwner(owner);
        for (Paint paint : paints) {
            if (paint.getName().equals(name)) {
                delete(name);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean savePaint(Paint paint) {
        try {
            save(paint);
            System.out.println("Paint guardado:");
            System.out.println("  Nombre: " + paint.getName());
            System.out.println("  Dueño: " + paint.getOwner());
            System.out.println("  Datos: " + paint.getData());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean selectPaintByNameAndOwner(String name, String owner) {
        return storage.values().stream()
                .anyMatch(paint -> paint.getOwner().equals(owner) && paint.getName().equalsIgnoreCase(name));
    }

}
