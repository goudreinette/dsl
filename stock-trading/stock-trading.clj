(ns stock-trading)

(defrecord Order
  [buy-or-sell
   quantity
   security
   instrument
   limit-price
   all-or-none
   value-as])

(defn order [buy-or-sell quantity & args]
  (map->Order
   (merge
    {:buy-or-sell (keyword buy-or-sell)
     :quantity quantity
     :security (nth args 0)
     :instrument (nth args 1)}
    (apply hash-map (drop 2 args)))))



(def buy  (partial order 'buy))
(def sell (partial order 'sell))
