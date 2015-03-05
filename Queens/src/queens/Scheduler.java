/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queens;

/**
 *
 * @author USER
 */
public class Scheduler {
    private final int k, limit;

    private final double lam;

    public Scheduler(int k, double lam, int limit) {
        this.k = k;
        this.lam = lam;
        this.limit = limit;
    }

    public double getTemp(int t) {
        if (t < limit) {
            double res = k * Math.exp((-1) * lam * t);
            return res;
        } else {
            return 0.0;
        }
    }
}
 
