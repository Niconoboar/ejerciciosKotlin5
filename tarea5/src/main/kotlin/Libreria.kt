/* import java.util.*

data class Usuario(val nombre: String, val id: String, val contraseña: String)

data class Transaccion(val tipo: String, val monto: Double, val fecha: Date)

class CuentaBancaria(val titular: Usuario, val numeroCuenta: String, var saldo: Double) {
    val transacciones = mutableListOf<Transaccion>()

    fun consultarSaldo(): Double {
        return saldo
    }

    fun realizarRetiro(monto: Double): Boolean {
        if (saldo >= monto) {
            saldo -= monto
            transacciones.add(Transaccion("Retiro", monto, Date()))
            return true
        }
        return false
    }

    fun depositar(monto: Double) {
        saldo += monto
        transacciones.add(Transaccion("Depósito", monto, Date()))
    }
}

class SistemaBancario {
    val cuentas = mutableMapOf<String, CuentaBancaria>() // Mapa de número de cuenta a CuentaBancaria

    fun crearCuenta(usuario: Usuario, saldoInicial: Double): String {
        val numeroCuenta = UUID.randomUUID().toString() // Genera un número de cuenta único
        val cuenta = CuentaBancaria(usuario, numeroCuenta, saldoInicial)
        cuentas[numeroCuenta] = cuenta
        return numeroCuenta
    }

    fun autenticar(id: String, contraseña: String): Usuario? {
        for ((_, cuenta) in cuentas) {
            if (cuenta.titular.id == id && cuenta.titular.contraseña == contraseña) {
                return cuenta.titular
            }
        }
        return null
    }

    fun realizarTransaccion(numeroCuenta: String, tipo: String, monto: Double): Boolean {
        val cuenta = cuentas[numeroCuenta]
        cuenta?.let {
            return when (tipo) {
                "Retiro" -> cuenta.realizarRetiro(monto)
                "Depósito" -> {
                    cuenta.depositar(monto)
                    true
                }
                else -> false
            }
        }
        return false
    }

    fun consultarSaldo(numeroCuenta: String): Double {
        return cuentas[numeroCuenta]?.consultarSaldo() ?: Double.NaN
    }

    fun obtenerTransacciones(numeroCuenta: String): List<Transaccion>? {
        return cuentas[numeroCuenta]?.transacciones
    }
}

fun main() {
    val sistemaBancario = SistemaBancario()

    val usuario1 = Usuario("Juan", "123456", "password1")
    val numeroCuenta1 = sistemaBancario.crearCuenta(usuario1, 1000.0)

    val usuario2 = Usuario("Maria", "789012", "password2")
    val numeroCuenta2 = sistemaBancario.crearCuenta(usuario2, 500.0)

    // Autenticación
    val usuarioAutenticado = sistemaBancario.autenticar("123456", "password1")
    usuarioAutenticado?.let {
        println("Bienvenido, ${it.nombre}!")
    }

    // Realizar transacciones
    sistemaBancario.realizarTransaccion(numeroCuenta1, "Retiro", 500.0)
    sistemaBancario.realizarTransaccion(numeroCuenta2, "Depósito", 200.0)

    // Consultar saldo
    println("Saldo de la cuenta 1: ${sistemaBancario.consultarSaldo(numeroCuenta1)}")
    println("Saldo de la cuenta 2: ${sistemaBancario.consultarSaldo(numeroCuenta2)}")

    // Obtener transacciones
    println("Transacciones de la cuenta 1:")
    sistemaBancario.obtenerTransacciones(numeroCuenta1)?.forEach {
        println("${it.tipo}: ${it.monto}")
    }
}
*/