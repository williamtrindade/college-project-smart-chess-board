<?php

namespace Database\Seeders;

use App\Models\ChessMatch;
use Illuminate\Database\Seeder;

class ChessMatchSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        ChessMatch::factory()->times(20)->create();
    }
}
