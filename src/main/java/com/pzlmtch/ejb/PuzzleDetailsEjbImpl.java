/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.ejb;

import com.pzlmtch.bean.PuzzleDetails;
import com.pzlmtch.exception.PzmRestException;
import java.util.HashMap;
import javax.ejb.Stateless;

@Stateless
public class PuzzleDetailsEjbImpl implements PuzzleDetailsEjb {

    public static HashMap<String, PuzzleDetails> puzzleDetailsMap = new HashMap<String, PuzzleDetails>();
    
     @Override
    public void insertPuzzleDetails(String sessionId, PuzzleDetails puzzleDetails) {
        puzzleDetailsMap.put(sessionId, puzzleDetails);
    }

    @Override
    public void updatePuzzleDetails(String sessionId, PuzzleDetails puzzleDetails) throws PzmRestException {
        if(!puzzleDetailsMap.containsKey(sessionId)) {
            throw new PzmRestException("PM001");
        }
        puzzleDetailsMap.put(sessionId, puzzleDetails);
    }

    @Override
    public void deletePuzzleDetails(String sessionId) throws PzmRestException {
        if(!puzzleDetailsMap.containsKey(sessionId)) {
            throw new PzmRestException("PM001");
        }
        puzzleDetailsMap.remove(sessionId);
    }

    @Override
    public PuzzleDetails getPuzzleDetails(String sessionId) throws PzmRestException {
        PuzzleDetails puzzleDetails = puzzleDetailsMap.get(sessionId);
        if(puzzleDetails == null) {
            throw new PzmRestException("PM001");
        }
        return puzzleDetails;
    }
    
    public String test() {
        return "test";
    }

    @Override
    public String getSimilarityMatrix(PuzzleDetails puzzleDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
