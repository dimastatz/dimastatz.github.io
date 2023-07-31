val a = List(1,2,3,4,5,5,7,7)

def ranges(x: Int) = x match {
  case i if i < 2 => "0-2"
  case i if i < 4 => "3-4"
  case i if i < 6 => "5-6"
  case _ => "unknown"
}


a.map(ranges)