/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.ejb;

import com.pzlmtch.bean.PuzzleDetails;
import java.util.HashMap;
import javax.ejb.Stateless;

@Stateless
public class PuzzleDetailsEjbImpl implements PuzzleDetailsEjb {

    public static HashMap<String, PuzzleDetails> puzzleDetailsMap = new HashMap<String, PuzzleDetails>();
    
    public String test() {
        return "test";
    }
    
}
