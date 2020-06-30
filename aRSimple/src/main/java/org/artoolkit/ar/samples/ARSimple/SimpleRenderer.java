/*
 *  SimpleRenderer.java
 *  ARToolKit5
 *
 *  Disclaimer: IMPORTANT:  This Daqri software is supplied to you by Daqri
 *  LLC ("Daqri") in consideration of your agreement to the following
 *  terms, and your use, installation, modification or redistribution of
 *  this Daqri software constitutes acceptance of these terms.  If you do
 *  not agree with these terms, please do not use, install, modify or
 *  redistribute this Daqri software.
 *
 *  In consideration of your agreement to abide by the following terms, and
 *  subject to these terms, Daqri grants you a personal, non-exclusive
 *  license, under Daqri's copyrights in this original Daqri software (the
 *  "Daqri Software"), to use, reproduce, modify and redistribute the Daqri
 *  Software, with or without modifications, in source and/or binary forms;
 *  provided that if you redistribute the Daqri Software in its entirety and
 *  without modifications, you must retain this notice and the following
 *  text and disclaimers in all such redistributions of the Daqri Software.
 *  Neither the name, trademarks, service marks or logos of Daqri LLC may
 *  be used to endorse or promote products derived from the Daqri Software
 *  without specific prior written permission from Daqri.  Except as
 *  expressly stated in this notice, no other rights or licenses, express or
 *  implied, are granted by Daqri herein, including but not limited to any
 *  patent rights that may be infringed by your derivative works or by other
 *  works in which the Daqri Software may be incorporated.
 *
 *  The Daqri Software is provided by Daqri on an "AS IS" basis.  DAQRI
 *  MAKES NO WARRANTIES, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 *  THE IMPLIED WARRANTIES OF NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS
 *  FOR A PARTICULAR PURPOSE, REGARDING THE DAQRI SOFTWARE OR ITS USE AND
 *  OPERATION ALONE OR IN COMBINATION WITH YOUR PRODUCTS.
 *
 *  IN NO EVENT SHALL DAQRI BE LIABLE FOR ANY SPECIAL, INDIRECT, INCIDENTAL
 *  OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 *  INTERRUPTION) ARISING IN ANY WAY OUT OF THE USE, REPRODUCTION,
 *  MODIFICATION AND/OR DISTRIBUTION OF THE DAQRI SOFTWARE, HOWEVER CAUSED
 *  AND WHETHER UNDER THEORY OF CONTRACT, TORT (INCLUDING NEGLIGENCE),
 *  STRICT LIABILITY OR OTHERWISE, EVEN IF DAQRI HAS BEEN ADVISED OF THE
 *  POSSIBILITY OF SUCH DAMAGE.
 *
 *  Copyright 2015 Daqri, LLC.
 *  Copyright 2011-2015 ARToolworks, Inc.
 *
 *  Author(s): Julian Looser, Philip Lamb
 *
 */

package org.artoolkit.ar.samples.ARSimple;


import org.artoolkit.ar.base.ARToolKit;
import org.artoolkit.ar.base.rendering.ARRenderer;
import javax.microedition.khronos.opengles.GL10;

/**
 * A very simple Renderer that adds a marker and draws a cube on it.
 */
public class SimpleRenderer extends ARRenderer {

    private int markerID = -1;
    private int markerID1 = -1;
    private int markerID2 = -1;
    private int markerID3 = -1;
    private int markerID4 = -1;
    private int markerID5 = -1;
    private int markerID6 = -1;
    private int markerID7 = -1;
    private int markerID8 = -1;
    private int markerID9 = -1;
    private int markerID10 = -1;
    private int markerID11 = -1;
    private int markerID12 = -1;
    private int markerID13 = -1;
    private int markerID14 = -1;
    private int markerID15 = -1;

    ARSimple mainActivity;

    public SimpleRenderer(ARSimple activity){
        this.mainActivity = activity;
    }

    /**
     * Markers can be configured here.
     */
    @Override
    public boolean configureARScene() {

        markerID = ARToolKit.getInstance().addMarker("nft;Data/marcozero");
        markerID1 = ARToolKit.getInstance().addMarker("nft;Data/cais_sertao");
        markerID2 = ARToolKit.getInstance().addMarker("nft;Data/paco_frevo");
        markerID3 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff_placa");
        markerID4 = ARToolKit.getInstance().addMarker("nft;Data/marcozero2");
        markerID5 = ARToolKit.getInstance().addMarker("nft;Data/marcozero1");
        markerID6 = ARToolKit.getInstance().addMarker("nft;Data/marcozero3");
        markerID7 = ARToolKit.getInstance().addMarker("nft;Data/marcozero4");
        markerID8 = ARToolKit.getInstance().addMarker("nft;Data/marcozero5");
        markerID9 = ARToolKit.getInstance().addMarker("nft;Data/marcozero6");
        markerID10 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff1");
        markerID11 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff2");
        markerID12 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff3");
        markerID13 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff4");
        markerID14 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff5");
        markerID15 = ARToolKit.getInstance().addMarker("nft;Data/torre_malakoff6");

        if (markerID < 0 || markerID1 < 0 || markerID2 < 0 || markerID3 < 0 || markerID4 < 0 || markerID5 < 0 || markerID6 < 0 || markerID7 < 0 || markerID8 < 0 || markerID9 < 0 || markerID10 < 0 || markerID11 < 0 || markerID12 < 0 || markerID13 < 0 || markerID14 < 0 || markerID15 < 0){
            return false;
        } else {
            return true;
        }
    }


    /**
     * Override the draw function from ARRenderer.
     */
    @Override
    public void draw(GL10 gl) {

        //MARCO ZERO
        if (ARToolKit.getInstance().queryMarkerVisible(markerID) || ARToolKit.getInstance().queryMarkerVisible(markerID4) || ARToolKit.getInstance().queryMarkerVisible(markerID5) || ARToolKit.getInstance().queryMarkerVisible(markerID6) || ARToolKit.getInstance().queryMarkerVisible(markerID7) || ARToolKit.getInstance().queryMarkerVisible(markerID8) || ARToolKit.getInstance().queryMarkerVisible(markerID9)) {
            mainActivity.setFoundMarker(true, markerID);
        }

        //CAIS DO SERTÃO
        else if (ARToolKit.getInstance().queryMarkerVisible(markerID1)){
            mainActivity.setFoundMarker(true, markerID1);
        }

        //PAÇO DO FREVO
        else if (ARToolKit.getInstance().queryMarkerVisible(markerID2)){
            mainActivity.setFoundMarker(true, markerID2);
        }

        //TORRE MALAKOFF
        else if (ARToolKit.getInstance().queryMarkerVisible(markerID3) || ARToolKit.getInstance().queryMarkerVisible(markerID10) || ARToolKit.getInstance().queryMarkerVisible(markerID11) || ARToolKit.getInstance().queryMarkerVisible(markerID12) || ARToolKit.getInstance().queryMarkerVisible(markerID13) || ARToolKit.getInstance().queryMarkerVisible(markerID14) || ARToolKit.getInstance().queryMarkerVisible(markerID15)){
            mainActivity.setFoundMarker(true, markerID3);
        }

        //NDA
        else {
            mainActivity.setFoundMarker(false, -1);
        }
    }
}