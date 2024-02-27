# p(x) =  a + b*x + c*x^2 + d*x^3
## p'(x) =    b + 2c*x + 3d*x^2
## p''(x) =    2c + 6d*x
## p'''(x) =    6d
---
# p' - p'' + p''' = b + 6d -2c + (2c - 6d)*x + 3d*x^2
# p - p' + p'' p''' = a + 2c -b -6d + (b + 6d -2c)*x + c*x^2 - 3d*x^2 + d*x^3

---
# $$F = \lambda \cdot \int_{-1.0}^{-0.5} (e^x - p'(x)) ^2 dx + \int_{-0.5}^{+0.5} (e^x - p(x)) ^2 dx + \lambda \cdot \int_{+0.5}^{+1.0} (e^x - p'(x)) ^2 dx$$

# $$F^{'}_a = \frac{1}{2} b +  \frac{1}{16} d -2e^{\frac{1}{2}} +2e^{-\frac{1}{2}} = 0$$

# $$F^{'}_b = 5 \lambda c + \frac{1}{2} a +  \frac{1}{16} c -2 \lambda e^{-\frac{1}{2}} +2 \lambda e^{-1} + e^{\frac{1}{2}} - 3 e^{-\frac{1}{2}} -2 \lambda e + 2 \lambda e^{\frac{1}{2}} = 0$$

# $$F^{'}_c = 5 \lambda b + 6 \lambda d +  \frac{3}{8} \lambda d +  \frac{1}{16} b +  \frac{1}{96}  d +  6 \lambda e^{-\frac{1}{2}} -  8 \lambda e^{-1} - 2.5  e^{\frac{1}{2}}  +  6.5 e^{-\frac{1}{2}}  -  2 \lambda e^{\frac{1}{2}}= 0$$

# $$F^{'}_d = 6 \lambda c + \frac{3}{8} \lambda c   +  \frac{1}{16} a +  \frac{1}{96} c -  18 \lambda e^{-\frac{1}{2}} -  1.5 \lambda e^{-\frac{1}{2}}  +  30 \lambda e^{-1} +  6  e^{\frac{1}{2}} +  \frac{5}{4}  e^{\frac{1}{2}} -  18  e^{-\frac{1}{2}} - \frac{7}{4}  e^{-\frac{1}{2}} -  6 \lambda e +  6 \lambda e^{\frac{1}{2}} +  1.5 \lambda e^{\frac{1}{2}} = 0$$

---

+++

---


# $$F^{'}_a = \frac{1}{2} b +  \frac{1}{16} d -2.08438 = 0$$

# $$F^{'}_b = \frac{1}{2}  a +  (\frac{1}{16} +5 \lambda) c   -2 \lambda e^{-\frac{1}{2}} +2 \lambda e^{-1}   -2 \lambda e + 2 \lambda e^{\frac{1}{2}}  -0.170871 = 0$$

# $$F^{'}_c = (\frac{1}{16} +  5 \lambda ) b + (\frac{1}{96}  + 6 \lambda  +  \frac{3}{8} \lambda ) d +      6 \lambda e^{-\frac{1}{2}} -  8 \lambda e^{-1}   -  2 \lambda e^{\frac{1}{2}}  -0.179354 = 0$$

# $$F^{'}_d =  \frac{1}{16} a  +  (  \frac{1}{96} + 6 \lambda  + \frac{3}{8} \lambda ) c     -  18 \lambda e^{-\frac{1}{2}} -  1.5 \lambda e^{-\frac{1}{2}}  +  30 \lambda e^{-1}  -  6 \lambda e +  6 \lambda e^{\frac{1}{2}} +  1.5 \lambda e^{\frac{1}{2}} -0.0257513 = 0$$
