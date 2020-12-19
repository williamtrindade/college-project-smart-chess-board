<?php

use App\Models\ChessMatch;
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

/**
 * Class CreateMatchesTable
 */
class CreateChessMatchesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('chess_matches', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table
                ->enum('winner', [
                    ChessMatch::WHITE_WINNER,
                    ChessMatch::BLACK_WINNER])
                ->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('chess_matches');
    }
}
