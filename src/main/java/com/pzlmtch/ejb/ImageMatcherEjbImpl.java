/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pzlmtch.ejb;

import com.pzlmtch.bean.PuzzleDetails;
import javax.ejb.EJB;
import javax.ejb.Stateless;
@
Stateless
public class ImageMatcherEjbImpl implements ImageMatcherEjb {

    //@EJB
    //private com.mycompany.imagematchermodule.NewSessionBeanRemote newSessionBean;

    @Override
    public String getSimilarityMatrix(PuzzleDetails puzzleDetails) {
       return "2"; 
      //  return newSessionBean.businessMethod();
        
        //return "dsdfs";
    }
  /*
     
                List<Pair<Keypoint>> matches = null;
        try {
            matches = process(puzzleDetails);
        } catch (IOException ex) {
        //    java.util.logging.Logger.getLogger(ImageMatcherImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                int cols = puzzleDetails.getWidth(), rows = puzzleDetails.getHeight();
                
                int[] values = new int[cols * rows];
                
                System.out.println("heightImages / rows : " + (puzzleDetails.getHeight() / rows));
                System.out.println("widthImage / cols : " + (puzzleDetails.getWidth() / cols));
                
                
                for(int i = 0; i < matches.size(); i++) {
                    int row_k = (int) (matches.get(i).getSecondObject().getY() / (puzzleDetails.getHeight() / rows));
                    int col_k = (int) (matches.get(i).getSecondObject().getX() / (puzzleDetails.getWidth() / cols));
                    
                    values[row_k * cols + col_k]++;
                    
                   // System.out.println(matches.get(i).getSecondObject().getX() + " " + matches.get(i).getSecondObject().getX());
                }
                
                StringBuilder similarityResult = new StringBuilder();
                
                for(int i = 0; i < values.length; i++) {
                    similarityResult.append(values[i]).append(" ");
                    if(i < values.length - 1 && i % cols == (cols - 1)) {
                        similarityResult.append("\n");
                    }
                }
                return similarityResult.toString();
    }

    public static List<Pair<Keypoint>> process(PuzzleDetails puzzleDetails) throws IOException {
        final FImage input_1 = ImageUtilities.readF(new File(puzzleDetails.getPuzzlePicture()));
                //heightImages = puzzleDetails.getHeight();
                //widthImage = puzzleDetails.getWidth();
        
		final FImage input_2 = ImageUtilities.readF(new File(puzzleDetails.getPiecePicture()));

		// Prepare the engine to the parameters in the IPOL demo
		final ASIFTEngine engine = new ASIFTEngine(false, 7);

		// Extract the keypoints from both images
		final LocalFeatureList<Keypoint> input1Feats = engine.findKeypoints(input_1);
		System.out.println("Extracted input1: " + input1Feats.size());
		final LocalFeatureList<Keypoint> input2Feats = engine.findKeypoints(input_2);
		System.out.println("Extracted input2: " + input2Feats.size());

		// Prepare the matcher, uncomment this line to use a basic matcher as
		// opposed to one that enforces homographic consistency
		// LocalFeatureMatcher<Keypoint> matcher = createFastBasicMatcher();
		final LocalFeatureMatcher<Keypoint> matcher = createConsistentRANSACHomographyMatcher();

		// Find features in image 1
		matcher.setModelFeatures(input1Feats);
		// ... against image 2
		matcher.findMatches(input2Feats);

		// Get the matches
		final List<Pair<Keypoint>> matches = matcher.getMatches();
                
                return matches;*/
	/*	System.out.println("NMatches: " + matches.size());

                for(int i = 0; i < matches.size(); i++) {
                    System.out.println(matches.get(i).getFirstObject().getX() + " " + matches.get(i).getFirstObject().getX());
                }
                                
		// Display the results
		final MBFImage inp1MBF = input_1.toRGB();
                
		final MBFImage inp2MBF = input_2.toRGB();
		DisplayUtilities.display(MatchingUtilities.drawMatches(inp1MBF, inp2MBF, matches, RGBColour.RED));*/
   // }
    
	/*private static LocalFeatureMatcher<Keypoint> createConsistentRANSACHomographyMatcher() {
		final ConsistentLocalFeatureMatcher2d<Keypoint> matcher = new ConsistentLocalFeatureMatcher2d<Keypoint>(
				createFastBasicMatcher());
		matcher.setFittingModel(new RobustHomographyEstimator(10.0, 100, new RANSAC.BestFitStoppingCondition(),
				HomographyRefinement.NONE));

		return matcher;
	}

	private static LocalFeatureMatcher<Keypoint> createFastBasicMatcher() {
		return new FastBasicKeypointMatcher<Keypoint>(100);
	}*/
    
}
