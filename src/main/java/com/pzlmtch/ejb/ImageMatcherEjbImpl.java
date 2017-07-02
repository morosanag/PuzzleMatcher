/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.ejb;

import com.pzlmtch.bean.PuzzleDetails;
import javax.ejb.Stateless;

@Stateless
public class ImageMatcherEjbImpl implements ImageMatcherEjb {

    @Override
    public String getSimilarityMatrix(PuzzleDetails puzzleDetails) {
        
        
        return "";
    }

}
