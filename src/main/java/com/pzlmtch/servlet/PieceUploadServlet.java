/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.servlet;

import com.pzlmtch.bean.PuzzleDetails;
import com.pzlmtch.ejb.PuzzleDetailsEjbImpl;
import com.pzlmtch.general.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author gabi
 */
@WebServlet("/uploadPieceImage")
@MultipartConfig
public class PieceUploadServlet extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Part filePart = request.getPart("file"); 
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
        InputStream fileContent = filePart.getInputStream();
        
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);

        fileName = Utils.generateFilename(fileName);
        
        File targetFile = new File(fileName);
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
    
        // get sessionId
        String sessionId = request.getSession().getId();
        
        PuzzleDetails puzzleDetails = PuzzleDetailsEjbImpl.puzzleDetailsMap.get(sessionId);
        puzzleDetails.setPiecePicture(fileName);
        PuzzleDetailsEjbImpl.puzzleDetailsMap.put(sessionId, puzzleDetails);
        
        Utils.addOkResponseServlet(response);
    }

}