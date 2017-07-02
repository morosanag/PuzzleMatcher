package com.pzlmtch.ejb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pzlmtch.bean.PuzzleDetails;
import com.pzlmtch.exception.PzmRestException;

public interface PuzzleDetailsEjb {

    public void insertPuzzleDetails(String sessionId, PuzzleDetails puzzleDetails) throws PzmRestException;
    public void updatePuzzleDetails(String sessionId, PuzzleDetails puzzleDetails) throws PzmRestException;
    public void deletePuzzleDetails(String sessionId) throws PzmRestException;
    public PuzzleDetails getPuzzleDetails(String sessionId) throws PzmRestException;
}
