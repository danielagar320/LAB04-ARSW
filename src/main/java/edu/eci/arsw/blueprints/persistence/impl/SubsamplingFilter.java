package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;

import java.util.ArrayList;
import java.util.List;


public class SubsamplingFilter implements Filter {
    List<Point> list;
    List <Point> fList = new ArrayList<>();
    int counter = 0;

    @Override
    public Blueprint applyFilter(Blueprint bp) {
        list = bp.getPoints();
        for (Point p:  list){
            if (counter % 2 == 0){
                fList.add(new Point(p.getX(), p.getY()));
            }
            counter+=1;
        }
        bp.setPoints(fList);

        return bp;
    }
}