import math
class Vector3D:
  def __init__(self, a1=0.0, a2=0.0, a3=0.0):
    self.a1 = a1
    self.a2 = a2
    self.a3 = a3

  def __add__(self, otro):
    return Vector3D(self.a1 + otro.a1, self.a2 + otro.a2, self.a3 + otro.a3)

  def __mul__(self, escalar):
    if isinstance(escalar, (int, float)):
      return Vector3D(
          escalar * self.a1, escalar * self.a2, escalar * self.a3
      )
    raise TypeError("El multiplicador debe ser un número escalar")

  def __rmul__(self, escalar):
    return self.__mul__(escalar)

  def longitud(self):
    return math.sqrt(self.a1**2 + self.a2**2 + self.a3**2)

  def normal(self):
    l = self.longitud()
    if l == 0:
      return Vector3D(0, 0, 0)
    return Vector3D(self.a1 / l, self.a2 / l, self.a3 / l)

  def __matmul__(self, otro):
    return self.a1 * otro.a1 + self.a2 * otro.a2 + self.a3 * otro.a3

  def __xor__(self, otro):
    x = self.a2 * otro.a3 - self.a3 * otro.a2
    y = self.a3 * otro.a1 - self.a1 * otro.a3
    z = self.a1 * otro.a2 - self.a2 * otro.a1
    return Vector3D(x, y, z)

  def __str__(self):
    return f"({self.a1}, {self.a2}, {self.a3})"

if __name__ == "__main__":
  v1 = Vector3D(1, 2, 3)
  v2 = Vector3D(4, 5, 6)

  print("Suma (v1 + v2):", v1 + v2)
  print("Escalar (2 * v1):", 2 * v1)
  print("Longitud de v1:", v1.longitud())
  print("Normal de v1:", v1.normal())
  print("Producto escalar (v1 @ v2):", v1 @ v2)
  print("Producto vectorial (v1 ^ v2):", v1 ^ v2)