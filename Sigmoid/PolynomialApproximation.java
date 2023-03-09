import java.io.*;
import java.util.*;
import java.math.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class PolynomialApproximation {

        public static void main(String[] args) {
                System.out.println("poly = a   +  b * x^1   +  c * x^2   +  ... ");
                System.out.println();
                System.out.println();

                /*
                BigDecimal[] poly0 = {new BigDecimal(1),new BigDecimal(2)};
                BigDecimal[] poly1 = {new BigDecimal(3),new BigDecimal(4),new BigDecimal(5)};
                
                System.out.print("poly0 := "); print(poly0); System.out.println();
                
                System.out.print("poly1 := "); print(poly1); System.out.println();
                
                System.out.print("poly0 x poly1 := "); print( polymult(poly0, poly1) ); System.out.println();

                System.out.print("poly0 + poly1 := "); print( polyplus(poly0, poly1) ); System.out.println();

                System.out.print("poly1(2) := "); System.out.println( polyvalue( poly1, new BigDecimal(2) ) ); System.out.println();
                */


                // z =  + 5.000000000000002e-01*x.^0  + 2.402875477632921e-01*x.^1  -1.447312423686313e-02*x.^3  + 6.417014221197733e-04*x.^5   -1.597507057561005e-05*x.^7  + 2.010839465901885e-07*x.^9  -9.935476152456395e-10*x.^11 ; 
                // z'=  + 2.402875477632921e-01      -4.341937271058939e-02*x.^2 + 3.208507110598867e-03*x.^4  +  1.118254940292703e-04*x.^6 + 1.809755519311696e-06*x.^8   -1.092902376770203e-08*x.^10 ;
                BigDecimal[] z    = {new BigDecimal(+ 5.000000000000002e-01),  new BigDecimal(+ 2.402875477632921e-01), BigDecimal.ZERO,   new BigDecimal(-1.447312423686313e-02),  BigDecimal.ZERO,  new BigDecimal(+ 6.417014221197733e-04),  BigDecimal.ZERO,  new BigDecimal(  -1.597507057561005e-05),  BigDecimal.ZERO,  new BigDecimal(+ 2.010839465901885e-07),  BigDecimal.ZERO,  new BigDecimal( -9.935476152456395e-10)  };
                BigDecimal[] detz = {new BigDecimal(+ 2.402875477632921e-01 ), BigDecimal.ZERO,  new BigDecimal( -4.341937271058939e-02), BigDecimal.ZERO,  new BigDecimal(+ 3.208507110598867e-03), BigDecimal.ZERO,  new BigDecimal(+  1.118254940292703e-04), BigDecimal.ZERO,  new BigDecimal(+ 1.809755519311696e-06), BigDecimal.ZERO,  new BigDecimal( -1.092902376770203e-08) };
 
                System.out.println( " + 5.000000000000002e-01*x.^0  + 2.402875477632921e-01*x.^1  -1.447312423686313e-02*x.^3  + 6.417014221197733e-04*x.^5   -1.597507057561005e-05*x.^7  + 2.010839465901885e-07*x.^9  -9.935476152456395e-10*x.^11 " );
                print(z);
                System.out.println( " + 2.402875477632921e-01      -4.341937271058939e-02*x.^2 + 3.208507110598867e-03*x.^4  +  1.118254940292703e-04*x.^6 + 1.809755519311696e-06*x.^8   -1.092902376770203e-08*x.^10 ");
                print(detz);
                System.out.println(BigDecimal.ZERO);
                System.out.println();
                System.out.println();
                System.out.println();

                BigDecimal[] N2 = new BigDecimal[1]; N2[0] = new BigDecimal(-2); 
                System.out.print("-2*z = "); print( polymult(N2, z) ); System.out.println();System.out.println();
                System.out.print("-2*z'= "); print( polymult(N2, detz) ); System.out.println();System.out.println();

                /*
                -2*z = -1.0      +  -0.48057508 .* x.^1  +  0.028946249 .* x.^3  +  -0.0012834028 .* x.^5  +  3.195014E-5 .* x.^7  -4.021679E-7 .* x.^9  +  1.9870952E-9 .* x.^11
                     = z0 + z1 * x^1 + z3 * x^3 + z5 * x^5 + z7 * x^7 + z9 * x^9 + z11 * x^11    

                -2*z'= -0.48057508   +  0.086838745 .* x.^2  +  -0.006417014 .* x.^4    +  -2.2365099E-4 .* x.^6   -3.619511E-6 .* x.^8  +  2.1858048E-8 .* x.^10
                     = z0' + z2' * x^2 + z4' * x^4 + z6' * x^6 + z8' * x^8 + z10' * x^10
                */

                BigDecimal z0 = new BigDecimal( -1.0 ); 
                BigDecimal z1 = new BigDecimal( -0.48057508); 
                BigDecimal z3 = new BigDecimal( 0.028946249); 
                BigDecimal z5 = new BigDecimal( -0.0012834028 ); 
                BigDecimal z7 = new BigDecimal( 3.195014E-5); 
                BigDecimal z9 = new BigDecimal( -4.021679E-7 ); 
                BigDecimal z11= new BigDecimal( 1.9870952E-9 ); 


                BigDecimal z_0 = new BigDecimal(  -0.48057508  ); 
                BigDecimal z_2 = new BigDecimal(  0.086838745 ); 
                BigDecimal z_4 = new BigDecimal(  -0.006417014  ); 
                BigDecimal z_6 = new BigDecimal(  -2.2365099E-4); 
                BigDecimal z_8 = new BigDecimal(  -3.619511E-6); 
                BigDecimal z_10= new BigDecimal(   2.1858048E-8); 

                BigDecimal Eight = new BigDecimal(  8  );

                BigDecimal E323, E525, E727, E929, Eb2b, Ed2d, Ef2f, result;

                E323 = Eight.pow(3).multiply(new BigDecimal(2.0/3));                
                E525 = Eight.pow(5).multiply(new BigDecimal(2.0/5));
                E727 = Eight.pow(7).multiply(new BigDecimal(2.0/7));
                E929 = Eight.pow(9).multiply(new BigDecimal(2.0/9));
                Eb2b = Eight.pow(11).multiply(new BigDecimal(2.0/11));
                Ed2d = Eight.pow(13).multiply(new BigDecimal(2.0/13));
                Ef2f = Eight.pow(15).multiply(new BigDecimal(2.0/15));
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();

                // Ldet_b: m11 x b  +  m12 x c  =  m10
                // Ldet_c: m21 x b  +  m22 x c  =  m20
                // b = ( m10 / m12 - m20 / m22 ) / ( m11 / m12 - m21 / m22 )
                // c = ( m10 / m11 - m20 / m21 ) / ( m12 / m11 - m22 / m21 ) 
                BigDecimal lambda, m11, m12, m10, m21, m22, m20,  b, c;

                lambda = toBD("135");
                System.out.println(lambda);

                m11 = toBD("32").add( E323.multiply(toBD("2")).multiply(lambda) );

                m12 = E323.multiply(toBD("6")).add( E525.multiply(toBD("2")).multiply(lambda) );

                m10 = toBD("16").multiply(z_0).add(E323.multiply(z_2)).add(E525.multiply(z_4)).add(
                       E727.multiply(z_6)).add(E929.multiply(z_8)).add(Eb2b.multiply(z_10)).add(
                        E323.multiply(lambda).multiply(z1)).add(E525.multiply(lambda).multiply(z3)).add(
                         E727.multiply(lambda).multiply(z5)).add(E929.multiply(lambda).multiply(z7)).add(
                          Eb2b.multiply(lambda).multiply(z9)).add(Ed2d.multiply(lambda).multiply(z11));
                m10 = toBD("-1").multiply(m10);

                m21 = E323.multiply(toBD("6")).add( E525.multiply(toBD("2")).multiply(lambda) );

                m22 = E525.multiply(toBD("18")).add( E727.multiply(toBD("2")).multiply(lambda) );

                m20 = E323.multiply(toBD("3")).multiply(z_0).add( E525.multiply(toBD("3")).multiply(z_2) ).add( E727.multiply(toBD("3")).multiply(z_4) ).add( E929.multiply(toBD("3")).multiply(z_6) ).add( Eb2b.multiply(toBD("3")).multiply(z_8) ).add( Ed2d.multiply(toBD("3")).multiply(z_10) ).add( E525.multiply(lambda).multiply(z1) ).add( E727.multiply(lambda).multiply(z3) ).add( E929.multiply(lambda).multiply(z5) ).add( Eb2b.multiply(lambda).multiply(z7) ).add( Ed2d.multiply(lambda).multiply(z9) ).add( Ef2f.multiply(lambda).multiply(z11) );
                m20 = toBD("-1").multiply(m20);

                // b = ( m10 / m12 - m20 / m22 ) / ( m11 / m12 - m21 / m22 )
                // c = ( m10 / m11 - m20 / m21 ) / ( m12 / m11 - m22 / m21 ) 
                b = div( div(m10, m12).subtract( div(m20, m22) ),
                         div(m11, m12).subtract( div(m21, m22) ) );

                c = div( div(m10, m11).subtract( div(m20, m21) ),
                         div(m12, m11).subtract( div(m22, m21) ) );

                System.out.println("b = " + b.setScale(22, RoundingMode.CEILING));
                System.out.println("c = " + c.setScale(22, RoundingMode.CEILING));
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("lambda = " + lambda + "\tpoly3 = 0.5 + " + b.setScale(17, RoundingMode.CEILING) + ".*x  + " + c.setScale(17, RoundingMode.CEILING)+".*x.^3;");

        }

        public static BigDecimal toBD(String str) {
                return new BigDecimal(str);
        }

        public static BigDecimal div(BigDecimal a, BigDecimal b) {                
                return a.divide( b, RoundingMode.CEILING );
        }

        public static void print(BigDecimal[] poly) {
                for (int i = 0; i < poly.length; i++) {
                        if (i != 0 ) System.out.print("\t +  ");
                        System.out.print( poly[i].floatValue() );
                        if (i != 0 ) System.out.print( " .* x.^" +i );
                }
                System.out.println();
        }

        public static BigDecimal polyvalue(BigDecimal[] poly, BigDecimal x) {

                BigDecimal result = new BigDecimal(0);

                for (int i = 0; i < poly.length; i++) {
                        BigDecimal XpowI = x.pow(i);
                 
                        result = result.add( poly[i].multiply(XpowI) );
                }

                return result;
        }

        public static BigDecimal[] polymult(BigDecimal[] poly0, BigDecimal[] poly1) {
                int degree0 = poly0.length - 1;  
                int degree1 = poly1.length - 1;  

                int degree2 = degree0 + degree1; 
                BigDecimal[] result = new BigDecimal[degree2 + 1];

                for (int i = 0; i < result.length; i++)
                        result[i] = new BigDecimal(0);

                //result[0] = result[0].add( poly0[0].multiply(poly1[0]) );  // result[0] += poly0[0] * poly1[0]

                for (int i = 0; i < poly0.length; i++) {
                        for (int j = 0; j < poly1.length; j++) {
                                result[i+j] = result[i+j].add( poly0[i].multiply(poly1[j]) ); 
                        }
                }

                return result;
        }

        public static BigDecimal[] polyplus(BigDecimal[] poly0, BigDecimal[] poly1) {

                int len = poly0.length;
                if (len < poly1.length) len = poly1.length;

                BigDecimal[] result = new BigDecimal[len];

                for (int i = 0; i < result.length; i++)
                        result[i] = new BigDecimal(0);

                if (poly0.length < result.length) {
                        for (int i = 0; i < poly0.length; i++)
                                result[i] = result[i].add( poly0[i] );
                } else {
                        for (int i = 0; i < result.length; i++)
                                result[i] = result[i].add( poly0[i] );
                }

                if (poly1.length < result.length) {
                        for (int i = 0; i < poly1.length; i++)
                                result[i] = result[i].add( poly1[i] );
                } else {
                        for (int i = 0; i < result.length; i++)
                                result[i] = result[i].add( poly1[i] );
                }

                return result;
        }



}