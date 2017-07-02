package com.pzlmtch.ejb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pzlmtch.bean.PuzzleDetails;
import com.pzlmtch.exception.PzmRestException;

public interface ImageMatcherEjb {

    public String getSimilarityMatrix(PuzzleDetails puzzleDetails);
}
